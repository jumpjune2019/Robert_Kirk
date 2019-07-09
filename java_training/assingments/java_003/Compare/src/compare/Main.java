package compare;

public class Main {

	public static void main(String[] args) {
		
		FileExtractor fe1 = new FileExtractor();
		fe1.setFileContent("D:\\Coding\\JUMP_pro_2019\\Robert_Kirk\\java_training\\assingments\\java_003\\Compare\\print_local.txt");
		String first = fe1.getFileContent();
		
		FileExtractor fe2 = new FileExtractor();
		fe2.setFileContent("D:\\Coding\\JUMP_pro_2019\\Robert_Kirk\\java_training\\assingments\\java_003\\Compare\\different_text.txt");
		String second = fe2.getFileContent();
		
		FileExtractor fe3 = new FileExtractor();
		fe3.setFileContent("D:\\Coding\\JUMP_pro_2019\\Robert_Kirk\\java_training\\assingments\\java_003\\Compare\\print_local.txt");
		String third = fe3.getFileContent();
		
		
		//different content different length
		StreamComparitor judge1 = new StreamComparitor(first, second);
		
		judge1.compareFiles();
		
		System.out.print("\n");
		//Same content same length
		StreamComparitor judge2 = new StreamComparitor(first, third);
		
		judge2.compareFiles();
		System.out.print("\n");
		third+= "            ";
		
		//Same content different Length
		StreamComparitor judge3 = new StreamComparitor(first, third);
		judge3.compareFiles();

	}

}
