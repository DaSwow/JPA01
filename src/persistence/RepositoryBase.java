
package persistence;

import entities.EntityBase;
import javax.persistence.EntityManager;


public abstract class RepositoryBase<T extends EntityBase> implements Repository<T>{

    private final EntityManager entityManager;
    private final Class<T> cls;
   
    public RepositoryBase(EntityManager entityManager,Class cls){
    this.entityManager=entityManager;
    this.cls=cls;
    }
//    @Override
//    public T find(int id) {
//        
//    }
//
//    @Override
//    public T save(T entity) {
//        
//    }
//
//    @Override
//    public void delete(T entity) {
//        
//    }
//
//    @Override
//    public void commit() {
//        
//    }
//    
    
    
}
