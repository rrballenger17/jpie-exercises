
// The Strategy Pattern enables you to easily swap specific implementation details of an 
// algorithm without requiring a complete rewrite. You can even swap implementations at run time. 

public interface Logging {
	void write(String message);
}