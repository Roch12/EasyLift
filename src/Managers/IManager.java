package Managers;

import java.util.List;

/**
 * Created by Johan on 09/03/2016.
 */
public  interface IManager<T> {

     List<T> GetAll() throws  Exception;
    T Get(String name)   throws Exception;
    void Insert(T model) throws Exception;
    void Update(T model) throws Exception;
    void Delete(T model) throws Exception;

}
