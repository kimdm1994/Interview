package com.tree;

public class Node {
	
	/* 출처 : https://leemoono.tistory.com/17?category=909799
	 * 예제 따라하기 이진트리
	 *  - 일반적으로 정렬된 선형자료구조의 탐색보다 이진트리를 활용한 이진탐색트리가 월등하게 탐색 시간이 짧다.
	 *  - 트리자료구조는 탐색에 걸리는 시간이 O(log n)인 반면, 선형 자료구조는 탐색에 걸리는 시간이 O(n)이다.
	 */
	
	
	// Node 클래스는 value, left, right를 필드로 가지고 있어야한다.
	// BinaryTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs, dfs를 구현한다.
	// dfs는 left - root - right
	int value;
	Node parent;
	Node left;
	Node right;
	
	public Node() {
	}
	
	public Node(int value, Node parent) {
		this.value = value;
		this.parent = parent;
	}
	
	public void addLeft(int value) {
		this.left = new Node(value, this);
	}
	
	public void addRight(int value) {
		this.right = new Node(value, this);
	}
}
