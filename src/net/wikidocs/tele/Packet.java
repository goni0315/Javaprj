package net.wikidocs.tele;

import java.util.ArrayList;
import java.util.HashMap;

public class Packet {

	private ArrayList<Item> items = new ArrayList<Item>();
	private HashMap<String, Item> nameAccess = new HashMap<String, Item>();

	public static void main(String[] args) {
		Packet packet = new Packet();

		Item item1 = Item.create("�̸�", 10, "������");
		Item item2 = Item.create("��ȭ��ȣ", 11, "01052754312");

		packet.addItem(item1);
		packet.addItem(item2);

		System.out.println("[" + packet.raw() + "]");

		Packet recvPacket = new Packet();

		recvPacket.addItem(Item.create("����", 8, null));
		recvPacket.addItem(Item.create("�ּ�", 30, null));
		recvPacket.parse("19920131������ ������ ���ȵ� 446-8       ");
		
		System.out.println(recvPacket.getItem("�ּ�").raw());
		
		

	}

	public void parse(String data) {
		byte[] bdata = data.getBytes();
		int pos = 0;
		for (Item item : items) {
			byte[] temp = new byte[item.getLength()];
			System.arraycopy(bdata, pos, temp, 0, item.getLength());
			pos += item.getLength();
			item.setValue(new String(temp));
		}
	}

	public Item getItem(String name) {
		return nameAccess.get(name);
	}

	public void addItem(Item item) {
		this.items.add(item);
		if(nameAccess.containsKey(item.getName())) {
			throw new RuntimeException(
					"�ߺ��� �̸��Դϴ� : ["+item.getName()+"]" );
		}
		nameAccess.put(item.getName(), item);
	}

	public String raw() {
		StringBuffer result = new StringBuffer();
		for (Item item : items)
			result.append(item.raw());
		return result.toString();
	}

}