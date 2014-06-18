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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
/**
 * Class computing a R script for several files
 * @see RloopInterface
 * @author Clément DELESTRE
 * @version 1.0
 *
 */
public class Rloop implements RloopInterface{
	/**
	 * The R script
	 */
	protected Path Rscript;
	/**
	 * File(s)
	 */
	protected ArrayList<Path> files;
	/**
	 * Constructor with only a script
	 * @param rscript
	 */
	public Rloop(Path rscript) {
		Rscript = rscript;
		files = new ArrayList<Path>();
	}
	/**
	 * Constructor with script and file(s)
	 * @param rscript
	 * @param files
	 */
	public Rloop(Path rscript,ArrayList<Path> files) {
		Rscript = rscript;
		this.files = files;
	}
	@Override
	public void setScript(Path script){
		this.Rscript=script;
	}
	@Override
	public void setFiles(ArrayList<Path> files){
		this.files=files;
	}
	@Override
	public void lauchScript() {
		for (Path p : files){
			System.out.println("Computing R script for "+p+"...");
			Runtime rt = Runtime.getRuntime();
			Process pr = null;
			try {
				pr = rt.exec("Rscript "+Rscript+" "+p.toString());		
			}
			catch (Exception e) {				
				e.printStackTrace();			
			}
			try {
				pr.waitFor();
			} 
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			String msg = "";
			if (pr.exitValue()!=0){
				String line = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
				try {
					while((line = reader.readLine()) != null) {
						msg +=line;	
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.err.println("***** ERROR with R script \n"+msg);
			}
		}
	}
}
