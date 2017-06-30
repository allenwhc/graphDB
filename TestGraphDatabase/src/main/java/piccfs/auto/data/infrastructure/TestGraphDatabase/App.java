package piccfs.auto.data.infrastructure.TestGraphDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Initialize objects
        MySQLAccess mysql = new MySQLAccess();
        Neo4jAccess neo4j = new Neo4jAccess();
        
        //Operate methods
        mysql.operate();
        neo4j.operate();
    }
}
