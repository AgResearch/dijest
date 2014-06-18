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

import java.nio.file.Path;
import java.util.ArrayList;
/**
 * Interface to extracting sequence between a maximum and a minimum given size
 * @author Clément DELESTRE
 * @version 1.0
 *
 */
public interface ExtractSequences {
	/**
	 * Extract sequences
	 */
	public void extractSequences();
	/**
	 * Set the maximum length of sequence to extract
	 * @param maxLength
	 */
	public void setMaxLength(int maxLength);
	/**
	 * Set the minimum length of sequence to extract
	 * @param minLength
	 */
	public void setMinLength(int minLength);
	/**
	 * Set files to parse
	 * @param files
	 */
	public void setInputFiles(ArrayList<Path> files);
}
