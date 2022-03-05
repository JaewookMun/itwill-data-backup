package xyz.itwill.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//Map 인터페이스를 상속받은 자료구조 클래스 : HashMap, HashTable, Properties 등
//=> 키(Key)과 값(Value:인스턴스)을 하나의 쌍(엔트리:Entry)으로 묶어서 관리하는 자료구조 클래스
//=> 키를 이용하여 값을 빠르게 검색하기 위해 사용
	//HashMap : 일반 메소드, HashTable : 싱크로나이즈된 메소드  (ArrayList와 Vector의 관계와 같다.)
	//List는 순서대로 저장하는데, 검색속도가 느린 점이 단점이다. (요소를 하나씩 비교하기 때문에)
	// Set : 순서가 없다. -> List : (순서 O) 검색속도가 느리다. -> Map
public class MapApp {
	public static void main(String[] args) {
		//Map 인터페이스를 상속받은 자료구조 클래스는 키와 값의 제네릭 타입에 자료형 전달 
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//Map.put(K key, V value) : Map 인스턴스에 엔트리를 추가하는 메소드
		//=> 키는 내부적으로 Set 인터페이스 타입으로 저장되며 값은 Collection 인터페이스 타입으로 저장
		//=> 키는 중복 저장되지 않으며 순서없이 저장
		map.put(1000, "홍길동");	// 1000이라는 정수값이 저장되는게 아니라 오토박싱이 일어나서 Integer객체가 저장된다.
		map.put(2000, "임꺽정");
		map.put(3000, "전우치");
		map.put(4000, "일지매");
		map.put(5000, "장길산");
		
		//Map.toString() : Map 인스턴스에 저장된 모든 엔트리를 문자열로 변환하여 반환하는 메소드
		//System.out.println("map.toString() = "+map.toString());
		System.out.println("map = "+map);
		System.out.println("================================================");
		//Map.put() 메소드 호출 시 전달된 엔트리의 키가 중복될 경우 엔트리의 값 변경
		map.put(2000, "임걱정");
		System.out.println("map = "+map);
		System.out.println("================================================");
		//Map.remove(K key) : Map 인스턴스에 저장된 엔트리 중 전달받은 키와 같은 엔트리를 삭제하는 메소드
		map.remove(4000);
		System.out.println("map = "+map);
		System.out.println("================================================");
		//Map.get(K key) : Map 인스턴스에 저장된 엔트리 중 전달받은 키와 같은 엔트리의 값을 반환하는 메소드
			//Map을 사용하는 가장 큰 이유
			//put(), get() 메소드가 제일 중요
		String name=map.get(1000);
		System.out.println("name = "+name);
		System.out.println("================================================");
		//Map.values() : Map 인스턴스에 저장된 모든 엔트리의 값을 Collection 인스턴스로 반환하는 메소드
		Iterator<String> iteratorValue = map.values().iterator();
		while(iteratorValue.hasNext()) {
			System.out.print(iteratorValue.next()+" ");
		}
		System.out.println();
		System.out.println("================================================");
		//Map.keySet() : Map 인스턴스에 저장된 모든 엔트리의 키를 Set 인스턴스로 반환하는 메소드
		Iterator<Integer> iteratorKey=map.keySet().iterator();
		while(iteratorKey.hasNext()) {
			Integer key = iteratorKey.next();
			System.out.print(key+" = "+map.get(key)+" ");
		}
		System.out.println();
		System.out.println("================================================");
			//map은 일괄처리를 목적으로 하지않는다. - key를 통한 value의 get이다. // put, get, keySet 메소드 3가지정도
			//일괄처리는 Set or List
		for(String value : map.values()) {
			System.out.print(value+" ");
		}
		System.out.println();
		System.out.println("================================================");
		for(Integer key : map.keySet()) {
			System.out.print(key+" = "+map.get(key)+" ");
		}
		System.out.println();
		System.out.println("================================================");
		
	
	}
}