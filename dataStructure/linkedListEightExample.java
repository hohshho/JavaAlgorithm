package linkedList2;

class node {
	int data;
	node next = null;
}

class LinkedList2 {
	node head;

	LinkedList2() {
		head = new node();
	}

	node get(int a) {
		node n = head;
		for (int i = 0; i < a; i++) {
			n = n.next;
		}
		return n;
	}

	void add(int a) {
		node end = new node();
		end.data = a;
		node n = head;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int a) {
		node n = head;
		while (n.next != null) {
			if (n.next.data == a) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void show() {
		node n = head.next;
		while (n.next != null) {
			System.out.print(n.data);
			n = n.next;
		}
		System.out.println(n.data);
	}

	void removeDu() {
		node n = head;

		while (n != null && n.next != null) {
			node pointer = n;
			while (pointer.next != null) {
				if (n.data == pointer.next.data) {
					pointer.next = pointer.next.next;
				} else {
					pointer = pointer.next;
				}
			}
			n = n.next;
		}
	}

	void nLast(int k) {
		node first = head;
		int count = 1;
		int num = 1;
		while (first.next != null) {
			count++;
			first = first.next;
		}
		node n = head;
		for (int i = 1; i < num - k + 1; i++) {
			n = n.next;
		}
		System.out.println();
	}

	node nLast2(node n, int k, Reference r) {
		if (n == null) {
			return null;
		}

		node found = nLast2(n.next, k, r);
		r.count++;
		if (r.count == k) {
			return n;
		}
		return found;
	}

	node nLast3(node n, int k) {
		node a = head;
		node b = head;
		for (int i = 0; i < k; i++) {
			if (b == null)
				return null;
			b = b.next;
		}

		while (b != null) {
			a = a.next;
			b = b.next;
		}
		return a;
	}
}

class Reference {
	public int count = 0;
}

public class eightExample {
	private static boolean deleteNode(node n) {
		if (n == null || n.next == null) {
			return false;
		}
		node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	private static node Partition(node n, int x) {
		node s1 = null;
		node e1 = null;
		node s2 = null;
		node e2 = null;

		while (n != null) {
			node nextNode = n.next;
			n.next = null;
			if (n.data < x) {
				if (s1 == null) {
					s1 = n;
					e1 = s1;
				} else {
					e1.next = n;
					e1 = n;
				}
			} else {
				if (s2 == null) {
					s2 = n;
					e2 = s2;
				} else {
					e2.next = n;
					e2 = n;
				}
			}
			n = nextNode;
		}
		if (s1 == null) {
			return s2;
		}
		e1.next = s2;
		return s1;
	}
	
	private static node Partition2(node n,int x) {
		node head = n;
		node tail = n;
		while(n!=null) {
			node next = n.next;
			if(n.data<x) {
				n.next = head;
				head = n;
			}else {
				tail.next = n;
				tail=n;
			}
			n=next;
		}
		tail.next = null; //原走厳 葵戚 焼諌 呪 亀 赤嬢辞

		return head;
	}

	public static void main(String[] args) {
		LinkedList2 list = new LinkedList2();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.show();
		list.removeDu();
		list.add(3);
		list.removeDu();
		list.show();
		list.show();
		list.nLast(2);
		Reference r = new Reference();
		node found = list.nLast2(list.head, 1, r);
		System.out.println(found.data);
		node found2 = list.nLast3(list.head, 2);
		System.out.println(found2.data);
		list.show();
		list.add(2);
		list.add(3);
		list.add(4);
		deleteNode(list.get(3));
		list.show();
		node nn = Partition2(list.get(1), 2);
		while (nn.next != null) {
			System.out.print(nn.data + " ->");
			nn = nn.next;
		}
		System.out.println(nn.data);
	}

}
//2. One Way Linked List1 / remove duplication value
//1) 獄遁紫遂
//- Hashset 紫遂! (徹 葵聖 亜走壱, 葵聖 達澗汽 1鉱拭 照杏鍵陥.)
//https://onsil-thegreenhouse.github.io/programming/java/2018/02/21/java_tutorial_1-23/
//走榎 公 石畏陥 ばばばば
//- space : O(n)
//- time : O(n)
//
//
//2) 獄遁 x 
//- 匂昔斗 鯵割生稽 固蒋税 葵採斗 魁猿走 旭精葵戚 赤蟹 達壱, 赤生檎 肢薦.
//- 原走厳 坪球研 肢薦拝 凶 神嫌亜 害.
//
//3. 及採斗 室奄
//- 1) k = 1, 穿端葛球 4析 井酔. 穿端葛球室壱 k研 捌陥. 益 板拭 1聖 希敗.
//( 戚 庚薦澗 益係惟 襲惟 熱虞壱 幻窮 庚薦亜 焼艦掘 せせせせせせせせ )
//- 2) 仙瑛硲窒
//(悦汽 蟹 訊 private 細心澗汽 照鞠劃)
//  - 壕伸戚蟹 梓端澗 什澱拭 匂昔斗幻 煽舌廃陥.
//  - 因娃 : O(N) , 獣娃 : O(N)
//- 3) 匂昔斗
//  - 森研 級嬢辞 及拭辞 砧腰属 葵聖 達壱 粛聖 凶, 匂昔斗研 馬蟹 希 幻級嬢辞  
//     及稽 2鯵 左鎧壱 旭戚 戚疑 / 及拭 匂昔斗亜 NULL聖 幻蟹檎 蒋税 匂昔斗亜
//     原走厳拭辞 2腰属 葵戚陥. 
//  - 因娃 : O(1) , 獣娃 : O(N)
//
//3. 庚薦! - 舘号狽 軒什闘拭辞 掻娃拭 赤澗 葛球研 肢薦馬獣神. 
//   (湛腰属 葛球亜 嬢鋸澗走 乞牽壱, 神送 肢薦 拝 葛球幻 握壱赤陥.)
//
//4. linkedlist 葵拭 魚虞 蟹刊奄!
//庚薦 : 舘号狽 軒什闘拭 赤澗 葛球級聖 x葵聖 奄層生稽 葵戚 拙精 依級精 図楕, 
//           笛 依級精 神献楕, 砧 督闘稽 蟹刊獣神.
//(舘, x澗 神献楕 督闘 嬢巨拭 竃亀 雌淫蒸陥.)
//
//* 号狛 1 : 砧匝稽 室酔奄
// - 匝原陥 匂昔斗 2鯵梢 識情背辞, 胡煽 
//
//* 号狛 2 : 蒋及稽 細戚奄
// - head人 tail 砧鯵 匂昔斗研 幻窮 板, 奄層 葵左陥 拙生檎 head蒋拭 細戚壱 奄層葵左陥 滴檎 tail及拭 細昔陥. 益 板 砧鯵 尻衣 
//tip!! - tail戚 原走厳 葵戚 焼諌 呪 亀 赤生艦, 原走厳 next澗 null聖 隔嬢操醤 廃陥.