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

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
/**
 * Interface that execute a R script for several files
 * @author Clément DELESTRE
 * @version 1.0
 */
public interface RloopInterface {
	/**
	 * Set the files
	 * @param files
	 */
	public void setFiles(ArrayList<Path> files);
	/**
	 * Launch the script
	 */
	public void lauchScript();
	/**
	 * Set the script.
	 * @param R script
	 */
	public void setScript(Path script);
}
