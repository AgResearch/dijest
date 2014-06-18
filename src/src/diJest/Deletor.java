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
 * Class deleting several files
 * @author Clément DELESTRE
 * @version 1.0
 * @see DeleteI
 */
public class Deletor implements DeleteI {
	protected ArrayList<Path> files; 
	/**
	 * Create Deletor object
	 * @param files to delete
	 */
	public Deletor( ArrayList<Path> files){
		this.files=files;
	}

	@Override
	public  void deleteFiles() { 
		for (Path file : files){
			boolean b = file.toFile().delete();
			if (!b)
				System.err.println("Clean failed for file : "+file);
		}
	}
}
