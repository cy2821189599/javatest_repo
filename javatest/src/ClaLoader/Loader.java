package ClaLoader;

public class Loader {
     public static void main(String[] args) {
    	 /*
    	  * 应用程序类加载器：Application ClassLoader，该类加载器由sun.misc.Launcher$AppClassLoader来实现，
    	  * 它负责加载用户类路径（ClassPath）所指定的类，开发者可以直接使用该类加载器，
    	  * 如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器
    	  */
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        /*
         * 该加载器由sun.misc.Launcher$ExtClassLoader实现，它负责加载JDK\jre\lib\ext目录中，
         * 或者由java.ext.dirs系统变量指定的路径中的所有类库（如javax.开头的类），开发者可以直接使用扩展类加载器。
         */
        System.out.println(loader.getParent());
        /*
         * 启动类加载器：Bootstrap ClassLoader，负责加载存放在JDK\jre\lib(JDK代表JDK的安装目录，下同)下，
         * 或被-Xbootclasspath参数指定的路径中的，并且能被虚拟机识别的类库（如rt.jar，
         * 所有的java.开头的类均被Bootstrap ClassLoader加载）。启动类加载器是无法被Java程序直接引用的。
         */
        System.out.println(loader.getParent().getParent());
    }
}
