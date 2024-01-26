
package model; 


import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class AnimalTableModel extends AbstractTableModel{
    
    private List<Cadastro> dados = new ArrayList<>(); 
    private String[] colunas = {"Nome Do Animal", "Raca", "Idade", "Sexo"};
    
    public String getColumnName (int column){
        return colunas[column];
    }

    @Override
    public int getRowCount() {
        return dados.size();
        }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int Linha, int coluna) {
        switch (coluna){
            case 0:
                return dados.get(Linha).getNomeDoAnimal();
            case 1: 
                return dados.get(Linha).getRaca();
            case 2: 
                return dados.get(Linha).getIdade();
            case 3:
                return dados.get(Linha).getSexo();
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object Valor, int Linha, int coluna){
        switch (coluna){
            case 0:
                dados.get(Linha).setNomeDoAnimal((String)Valor);
                break;
            case 1: 
                dados.get(Linha).setRaca((String)Valor);
                break;
            case 2: 
                dados.get(Linha).setIdade(Integer.parseInt((String)Valor));
                break;
            case 3:
               dados.get(Linha).setSexo((String)Valor);
               break;
        }
        this.fireTableRowsUpdated(Linha, Linha);
    }    
    
    public void addRow(Cadastro c){
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
        public void removeRow(int Linha){
            this.dados.remove(Linha);
            this.fireTableRowsDeleted(Linha, Linha);
        }
        
    }
    
   

