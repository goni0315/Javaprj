package oop.interf;

public  class Exam {
	
	private int kor;
	private int eng;
	private int soc;
	private AvgListener avglistener;
	
	
	public void setAvglistener(AvgListener avglistener) {
		this.avglistener = avglistener;
	}

	public Exam() {
		this(1, 2, 3);
	}

	public Exam(int kor, int eng, int soc) {
		this.kor = kor;
		this.eng = eng;
		this.soc = soc;
	}

	public  double avg() { /////////////////////
		return avglistener.avg();
	}

	public double total() {

		return kor + eng + soc;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}
	
	
}