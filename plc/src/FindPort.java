

import gnu.io.CommPortIdentifier;

import java.util.ArrayList;
import java.util.Enumeration;


public class FindPort {
    public static void main(String[] args)
    {
        for(String tmp:findPort()){
            System.out.println(tmp);
        }
        System.exit(0);
    }
    public static final ArrayList<String> findPort() {

        @SuppressWarnings("unchecked")
        //获得当前可用串口
                Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();//获得所有串口

        ArrayList<String> portNameList = new ArrayList<>();
        //串口名字添加到List并返回
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }
}