package servlets;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Dept {
	private int id;
	private String name;
	private String location;
	
	public Dept() {} 
	public Dept(int id, String name, String location) { 
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public String getLocation() {
		return location;
	}
 
	public void setLocation(String location) {
		this.location = location;
	}
	
 
}