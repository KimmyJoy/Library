package codingtest.kopo.ac.kr;

import java.util.ArrayList;
import java.util.List;

public class CalculLRU {

	 public static int calculateExecutionTime(int cacheSize, String[] cities) {
		 if (cacheSize == 0) {
	            return cities.length * 5; // 캐시 크기가 0이면 모든 도시는 cache miss로 처리됨
	        }

	        List<String> cache = new ArrayList<>(); // 캐시 저장소
	        int executionTime = 0;

	        // 1.5버전의 배열
	        //문제를 바라볼때 항상 전체를 고민하는 것이 아니고 쪼갤 줄 알아야한다
	        for (String city : cities) {
	            city = city.toLowerCase(); // 대소문자 구분하지 않음

	            // 캐시에 도시가 존재하는지 확인
	            if (cache.contains(city)) {
	                // cache hit
	                cache.remove(city); // 가장 최근 사용된 위치로 이동하기 위해 제거
	                cache.add(city); // 가장 최근 사용된 위치로 추가
	                executionTime += 1;
	            } else {
	                // cache miss
	                if (cache.size() >= cacheSize) {
	                    cache.remove(0); // 가장 오래된 데이터 제거
	                }
	                cache.add(city); // 가장 최근 사용된 위치로 추가
	                executionTime += 5;
	            }
	        }

	        return executionTime;
	    }
}
