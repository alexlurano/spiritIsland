/**
 * 
 */
/**
 * @author agerh
 *
 */
module temporary {
	requires java.xml;
	requires gson;
	requires java.sql;
	requires java.desktop;
	exports structural to gson;
	opens structural to gson;
}