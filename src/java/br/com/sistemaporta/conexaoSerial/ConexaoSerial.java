
package br.com.sistemaporta.conexaoSerial;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jssc.SerialPort;
import jssc.SerialPortException;

@ManagedBean
@SessionScoped
public class ConexaoSerial {
    
   private SerialPort conexao;

    public ConexaoSerial() {
    }
   
   
    
    public void StatusPorta(String porta){
        
        this.conexao = new SerialPort(porta);
        try {
        conexao.openPort();//Open serial port
        conexao.setParams(9600, 8, 1, 0);//Set params.
        byte[] buffer = conexao.readBytes();//Read 10 bytes from serial port
        conexao.closePort();//Close serial port
        }
        catch (SerialPortException ex) {
        System.out.println(ex);
        }
    }
    
    public void mandaComando(Boolean status){
        String porta = "COM4";
        this.conexao= new SerialPort(porta);
        String comando="";
        if(status == true){
            comando = "a";
        }
        try {
            
        conexao.openPort();//Open serial port
        conexao.setParams(SerialPort.BAUDRATE_9600, 
         SerialPort.DATABITS_8,
         SerialPort.STOPBITS_1,
         SerialPort.PARITY_NONE);//Set params. Also you can set params by this string: serialPort.setParams(9600, 8, 1, 0);
        conexao.writeString(comando);//Write data to port
        conexao.closePort();//Close serial port
        }
        catch (SerialPortException ex) {
        System.out.println(ex);
        }
    }

    /**
     * @return the conexao
     */
    public SerialPort getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(SerialPort conexao) {
        this.conexao = conexao;
    }
   
   
    
}
