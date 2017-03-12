package org.cmg.jresp.benchmark;

import java.util.Random;

import org.armedbear.lisp.get_properties;

public class Data {
String[] strings;
Integer[] integers;
Double[] doubles;
Boolean[] booleans;
Random random;
public Data(String[] strings, Integer[] integers, Double[] doubles, Boolean[] booleans){
	this.strings = strings;
	this.integers = integers;
	this.doubles = doubles;
	this.booleans = booleans;
	this.random = new Random();
}
public String getRandomString() {
	return strings[getRandom(strings.length)];

}
public Integer getRandomInteger(){
	return integers[getRandom(integers.length)];
}
public Double getRandomDouble(){
	return doubles[getRandom(doubles.length)];
}
public Boolean getRandomBoolean(){
	return booleans[getRandom(booleans.length)];
}
private int getRandom(int max){
	return random.nextInt(max);
}

public Object getRandomData(){
	int random = getRandom(4);
	switch(random) {
	case 0: return getRandomString();
	case 1: return getRandomInteger();
	case 2: return getRandomDouble();
	case 3: return getRandomBoolean();
	}
	return null;
}
}

