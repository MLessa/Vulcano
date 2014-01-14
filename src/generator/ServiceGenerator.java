package generator;


public class ServiceGenerator <T> {
	private T entity;

	public ServiceGenerator(T entity) {
		this.entity = entity;
	}
	
	public void generate(){
		AnnotationGetter.getVarcharColumnAnnotations(entity.getClass());
	}
	
	
	
}
