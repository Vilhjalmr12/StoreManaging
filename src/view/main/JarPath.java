package view.main;

public class JarPath {
	//Attributes
	private static String jarPath = JarPath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	//private static String jarFile = "bin";
	private static String jarFile = "StoreManager.jar";
	
	public static String getPath() {
		jarPath = JarPath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		jarPath = jarPath.replaceAll("%20", " ");
		jarPath = jarPath.split(jarFile)[0];
		return jarPath + "data/";
	}
}
