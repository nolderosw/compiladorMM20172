package compilador;

import java.util.HashMap;
import java.util.Map;

public final class RegAndOpCodes {
    
    //mapas (dicionários) que contém os opcodes e os endereços de cada instrução e registradores, respectivamente
    private final Map<String, String> registradores = new HashMap<>();
    private final Map<String, String> opcodes = new HashMap<>();
    
    //criador que alimenta os dicionários com as chaves e os valores
    public RegAndOpCodes() {
        instanciaRegistradores();
        instanciaOpcodes();
    }
    
    //retorna o endereço binário (em string) do registrador passado como parâmetro
    //ex.: "rc" retorna "0010"
    public String getRegistrador(String registrador) {
        return this.registradores.get(registrador);
    }
    
    //retorna o opcode binário (sm string) da operação passada como parâmetro
    //ex.: "AND" retorna "00100"
    public String getOpcode(String opcode) {
        return this.opcodes.get(opcode);
    }
    
    //alimenta o dicionário dos registradores
    public void instanciaRegistradores() {
        this.registradores.put("R0", "0000");
        this.registradores.put("R1", "0001");
        this.registradores.put("R2", "0010");
        this.registradores.put("R3", "0011");
        this.registradores.put("R4", "0100");
        this.registradores.put("R5", "0101");
        this.registradores.put("R6", "0110");
        this.registradores.put("R7", "0111");
        this.registradores.put("R8", "1000");
        this.registradores.put("R9", "1001");
        this.registradores.put("XL", "1010");
        this.registradores.put("XH", "1011");
    }
    
    //alimenta o dicionário dos opcodes
    public void instanciaOpcodes() {
        this.opcodes.put("ADD","00000");
        this.opcodes.put("ADI","00001");
        this.opcodes.put("SUB","00010");
        this.opcodes.put("SUBI","00011");
        this.opcodes.put("AND","00100");
        this.opcodes.put("ANDI","00101");
        this.opcodes.put("OR","00110");
        this.opcodes.put("ORI","00111");
        this.opcodes.put("EOR","01000");
        this.opcodes.put("EORI","01001");
        this.opcodes.put("NOT","01010");
        this.opcodes.put("INC","01011");
        this.opcodes.put("DEC","01100");
        this.opcodes.put("MUL","01101");
        this.opcodes.put("MULI","01110");
        this.opcodes.put("SHL","01111");
        this.opcodes.put("SHR","10000");
        this.opcodes.put("MOV","10001");
        this.opcodes.put("LDI","10010");
        this.opcodes.put("IN","10011");
        this.opcodes.put("OUT","10100");
        this.opcodes.put("JMP","10101");
        this.opcodes.put("RJMP","10110");
        this.opcodes.put("BRL","10111");
        this.opcodes.put("BRLE","11000");
        this.opcodes.put("BRE","11001");
        this.opcodes.put("BRNE","11010");
        this.opcodes.put("BRGE","11011");
        this.opcodes.put("BRG","11100");
        this.opcodes.put("BRZ","11101");
        this.opcodes.put("NOP","11110");
        this.opcodes.put("RESET","11111");
    }
}

