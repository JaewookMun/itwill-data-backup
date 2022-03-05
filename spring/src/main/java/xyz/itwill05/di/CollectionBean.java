package xyz.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> nameList;
	private Set<String> nameSet;
	
	// 제네릭을 인터페이스로 선언한 경우 모든 자식클래스의 객체를 요소로 저장
	private List<Controller> controllerList;
	private Set<Controller> controllerSet;
	private Map<String, Controller> controllerMap;
	private Properties controllerProperties;
		// map 상속 -> HashMap, HashTable, Properties (대표적 클래스)
		// Properties는 key와 value가 모두 String인 점이 Map과 다른 점이다. -> 제네릭을 사용하지 않는다.
	
	public CollectionBean() {
		System.out.println("### CollectionBean 클래스의 기본 생성자 호출 ###");
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

	public Properties getControllerProperties() {
		return controllerProperties;
	}

	public void setControllerProperties(Properties controllerProperties) {
		this.controllerProperties = controllerProperties;
	}

	
}
