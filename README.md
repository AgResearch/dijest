dijest
======

Program doing in silico digestion
-----------


DiJest program performs in silico digestion looping on restrict command belonging to EMBOSS package for several enzymes then parse the results to store only the fragments length (separated by a line break). DiJest can also compute a R script and/or extract fragments sequence thanks to extractseq command belonging to EMBOSS package. 


Please check you have installed EMBOSS on your computer before using it or download it on its [website](http://emboss.sourceforge.net/).




After parsing restrict results, DiJest can launch a R script with the result files as argument. 
There is an example of R script to make histograms [here](https://github.com/AgResearch/dijest/tree/master/ScriptR)  but you can specify your owm.
After this step, diJest can use extractseq command to extract fragments sequence. Finally, diJest is also
able to delete output file (not restrict outputfile) if you don't need it anymore.
You can find a picture explain the DiJest Pipeline in the [Doc repertory](
https://github.com/AgResearch/dijest/tree/master/Doc)


To know how to use DiJest, use '-h' or '--help' option. For example : java -jar dijest.jar -h

For any enquiries please [contact the author](mailto:cclementddel@gmail.com)

Clement DELESTRE (c) 2014

