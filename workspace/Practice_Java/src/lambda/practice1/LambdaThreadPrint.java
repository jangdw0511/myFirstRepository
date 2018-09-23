package lambda.practice1;

public class LambdaThreadPrint {
	
	private int value = 4;
	
	private void doit() {
		
		int value = 6;
		
		Runnable r = new Runnable(){
			//public final int value = 5;
			public void run(){
				//int value = 10;
				System.out.println("Runnable �͸�Ŭ������ ���� ���� Thread�� ����");
				System.out.println(value);
				//  System.out.println(this.value); /*error*/
			}
		};
		
		Thread t1 = new Thread(r);
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread ���ڷ� ���޵� Runnable �͸�Ŭ����");
				System.out.println(value);
			//  System.out.println(this.value); /*error*/
			}
		});
		t2.start();
		
		Runnable r2 = () -> {
			System.out.println("Runnable�� Lambda�������� ���� ���� Thread�� ����");
			System.out.println(this.value);
			//System.out.println(value);
		};
		Thread t3 = new Thread(r2);
		t3.start();
		
		Thread t4 = new Thread(() -> {
			System.out.println("Thread�� ���ڷ� ���޵� Lambda Ŭ����");
			System.out.println(this.value);
			//System.out.println(value);
		});
		t4.start();

	}
	
	public static void main(String[] args) {
		LambdaThreadPrint l = new LambdaThreadPrint();
		l.doit();
	}

}
