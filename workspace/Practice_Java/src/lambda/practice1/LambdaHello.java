package lambda.practice1;

public class LambdaHello {

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous class");
			}
		}).start();
		
		//���� thread�� ������ ������ Lambda �������� ���
		new Thread(() -> System.out.println("Lambda expression")).start();
	}
}
