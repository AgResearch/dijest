/**
 *  DiJest is a program Program doing in silico digestion.
    Copyright (C) 2014 Clément DELESTRE (cclementddel@gmail.com)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package diJest;

import java.io.IOException;
import java.util.Iterator;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Switch;
import com.martiansoftware.jsap.stringparsers.FileStringParser;
/**
 * Main class of dijest project
 * @author Clément DELESTRE
 * @version 1.0
 *
 */
public class Dijest {


	public static void main(String[] args){
		JSAP jsap = new JSAP();

		FileStringParser fsp =  FileStringParser.getParser(); // call the factory
		fsp.setMustExist(true); // the file must exist

		// option for display help
		Switch help = new Switch("help")
		.setShortFlag('h')
		.setLongFlag("help");
		help.setHelp("Print help and exit.");

		// GNU GPL
		Switch warranty = new Switch("warranty")
		.setShortFlag('w')
		.setLongFlag("warranty");
		warranty.setHelp("Print warranty GNU-GPL and exit");

		// option for input file
		FlaggedOption input = new FlaggedOption("Sequence File")
		.setStringParser(fsp) 
		.setRequired(true) 
		.setShortFlag('s') 
		.setLongFlag("sequence");
		input.setHelp("Input genome sequence (fasta format).");

		//option for enzyme file
		FlaggedOption enzyme = new FlaggedOption("Enzyme File")
		.setStringParser(fsp) 
		.setRequired(true)
		.setShortFlag('e')
		.setLongFlag("enz");
		enzyme.setHelp("File with several enzymes name separated by a line break.");

		//option for clean
		Switch clean = new Switch("clean")
		.setShortFlag('c') 
		.setLongFlag("clean");
		clean.setHelp("Delete output files created by "+DijestUtils.appliName+" (not restrict output files).");

		//option for rscript
		FlaggedOption r = new FlaggedOption("rscript")
		.setStringParser(fsp) 
		.setShortFlag('r');
		r.setHelp("R script launch with output file containing fragments length as argument");

		//option for extract sequence
		Switch extract = new Switch("extract fragments sequences")
		.setShortFlag('x') 
		.setLongFlag("ext");
		extract.setHelp("Extract fragments sequences (thanks to extractseq command) after parsing results and record it in file in the following format : input_enzyme_restrict.out_extractFragmentsSequences.fasta\n/!\\ Warning : extractseq command doesn't support multi-FASTA format");

		//compute all options
		try {
			// mandatory option
			jsap.registerParameter(input);
			jsap.registerParameter(enzyme);
			// optionnal options
			jsap.registerParameter(clean);
			jsap.registerParameter(r);
			jsap.registerParameter(extract);
			// help
			jsap.registerParameter(help);
			jsap.registerParameter(warranty);
		} catch (JSAPException e) {
			System.err.println("Error with JSAP parameters : ");
			e.printStackTrace();
		}
		JSAPResult config = jsap.parse(args);    
		if (config.getBoolean("help"))
			displayUsage(jsap);
		if (config.getBoolean("warranty")){
			System.out.println(DijestUtils.getWarranty());
			System.exit(2);
		}
		if (config.success()) {
			LoopingRestrictInterface lr = new LoopingRestrict(config.getFile("Sequence File").toPath(),config.getFile("Enzyme File").toPath());
			ParsingResult pr = new ParsingRestrictResult(config.getFile("Sequence File").toPath(),config.getFile("Enzyme File").toPath());
			// compute the 2 main class
			try {
				lr.restrictRun();
				pr.parsingRun();
			} catch (IOException e) {
				System.err.println("ERROR WITH FILE");
				e.printStackTrace();
				System.err.println("*********\n\n System will exit *********\n\n");
				System.exit(1);
			}

			// compute R script
			if  (config.getFile("rscript")!=null){
				RloopInterface rl = new Rloop(config.getFile("rscript").toPath(),pr.getOutputFiles());
				rl.lauchScript();
			}

			// extract sequence from output restrict file
			if  (config.getBoolean("extract fragments sequences")){
				ExtractSequences es = new Extractor(lr.getOutputFilesName(),config.getFile("Sequence File").toString());
				es.extractSequences();
			}

			// now clean
			if (config.getBoolean("clean")){
				DeleteI deletor = new Deletor(pr.getOutputFiles());
				deletor.deleteFiles();
			}

		}
		else {
			for (Iterator errs = config.getErrorMessageIterator();
					errs.hasNext();) {
				System.err.println("Error: " + errs.next());
			}
		}
	}

	public static void displayUsage(JSAP jsap){
		System.out.println(DijestUtils.getCopyright());
		System.out.println("Desctiption : ");
		System.out.println(DijestUtils.getDescription());
		System.out.println("Usage: java -jar dijest.jar\t\t" + jsap.getUsage()+"\n");
		System.out.println(jsap.getHelp());
		//System.out.println(booleanRules());
		System.exit(2);
	}
	/**
	 * Could be usefull to inform the user of what is "false" and what is "true".
	 * @return rules
	 */
	private static String booleanRules() {
		return " \nThe following arguments are interpreted as TRUE: 1 t true y yes (case-insensitive)\nThe following arguments are interpreted as FALSE: 0 f false n no (case-insensitive)\n\n";
	}
}
