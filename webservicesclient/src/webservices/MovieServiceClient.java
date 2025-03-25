//package webservices;
//
//import java.util.List;
//
//import org.apache.cxf.frontend.ClientProxyFactoryBean;
//
//public class MovieServiceClient {
//	
//	public static void main(String[] args) {
//		ClientProxyFactoryBean client= new ClientProxyFactoryBean();
//		client.setAddress("http://localhost:7777/MovieService");
//		MovieService ms= client.create(MovieService.class);
//		System.out.println(ms.getAllMovies());
//		System.out.println(ms.getMovie(1));
//		System.out.println(ms.getMovie(5));
//		ms.addMovie(new Movie(6,"DAYyy","english","action"
//				,List.of("Tom")));
////		ms.removeMovie(new Movie(6,"DAYyy","english","action"
////				,List.of("Tom")));
//		System.out.println(ms.getAllMovies());
//	}
//
//}
