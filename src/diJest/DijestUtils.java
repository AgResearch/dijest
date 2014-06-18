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
/**
 * DiJest informations class
 * @author Clément DELESTRE
 * @version 1.0
 * @since 1.0
 */
public class DijestUtils {
	/**
	 * Software's name
	 */
	public static final String appliName ="diJest";
	/**
	 * Version
	 */
	public static final float version=(float)1.0;
	/**
	 * Author
	 */
	public static final String author ="Clément DELESTRE";

	/**
	 * Year
	 */
	public static final int year=2014;
	/**
	 * email
	 */
	public static final String email="cclementddel@gmail.com";

	/**
	 * Get the GPL Warranty 
	 * @return GPL Warranty
	 */
	public static String getWarranty() {
		return  appliName+" is a program performs in silico digestion.\n Copyright (C) "+year+" " + author+ " ("+email+")"+"\n This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. \n\n This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.\n\n You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.\n\nTHERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM “AS IS” WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS WITH YOU. SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.";
	}
	/**
	 * Get the copyright 
	 * @return copyright
	 */
	public static String getCopyright(){
		return appliName+" version "+version+"\tCopyright (C) "+year+"\t"+author+" ("+email+")\nThis program comes with ABSOLUTELY NO WARRANTY; for details use warranty option";
	}
	/**
	 * Get program's description
	 * @return description
	 */
	public static String getDescription(){
		return 	"Program performs in silico digestion looping on restrict command belonging to EMBOSS package for several enzymes then parse the results to store only the fragments length (separated by a line break).\n"+appliName+" can also compute a R script and/or extract fragments sequence thanks to extractseq command belonging to EMBOSS package. \nPlease check you have installed EMBOSS ( http://emboss.sourceforge.net/ )on your computer before using "+appliName+"\nPlease note that "+appliName+" use JSAP library version 2.1 -dowloaded in June 2014- under LGPL, more informations here : http://www.martiansoftware.com/jsap/";

	}
}
