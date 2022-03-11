
package com.jjca.triqui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Random;

public class Ventana extends javax.swing.JFrame {

    int turn=1;
    int jugadores=1;
    int p1=0;
    int p2=0;
    String j1;
    String j2;
    String c1;
    String c2;
    Font fuente = new Font("Calibri",Font.BOLD,30);
    JButton List[] = new JButton[9];
 
    public Ventana() {
        initComponents();
        setResizable(false);
        setLocation(400,200);
        setLayout(null);
        rb1.setSelected(true);
        bt1.setFont(fuente);
        bt2.setFont(fuente);
        bt3.setFont(fuente);
        bt4.setFont(fuente);
        bt5.setFont(fuente);
        bt6.setFont(fuente);
        bt7.setFont(fuente);
        bt8.setFont(fuente);
        bt9.setFont(fuente);
        List[0]=(JButton) add(bt1);
        List[1]=(JButton) add(bt2);
        List[2]=(JButton) add(bt3);
        List[3]=(JButton) add(bt4);
        List[4]=(JButton) add(bt5);
        List[5]=(JButton) add(bt6);
        List[6]=(JButton) add(bt7);
        List[7]=(JButton) add(bt8);
        List[8]=(JButton) add(bt9);
        labelj1.setFont(new Font("Calibri",Font.BOLD,18));
        labelj2.setFont(new Font("Calibri",Font.BOLD,18));
        Turno.setFont(fuente);
        CambiarTurno();
        Reset();
    }
    
    public void CambiarTurno()
    {
        if (turn==1)
        {
            Turno.setText("Turno: X");
        }
        else if (turn==2)
        {
            Turno.setText("Turno: O");
        }
        labelg1.setText("Ganadas: "+p1);
        labelg2.setText("Ganadas: "+p2);
    }
    
    public void Reset()
    {
        if(jugadores==1)
        {
            j1="Jugador";
            j2="Computadora";
            labelj1.setText(j1);
            labelj2.setText(j2);
        }
        else if(jugadores==2)
        {
            j1="Jugador 1";
            j2="Jugador 2";
            labelj1.setText(j1);
            labelj2.setText(j2);
        }
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
    }
    
    public void Ganar(JButton Bot1, JButton Bot2, JButton Bot3)
    {
        if(jugadores==1)
        {
            c1="jugador";
            c2="la computadora";
        }
        else if(jugadores==2)
        {
            c1="jugador 1";
            c2="el jugador 2";
        }
        
        if (Bot1.getText()=="X" && Bot2.getText()=="X" && Bot3.getText()=="X")
        {
            
            JOptionPane.showMessageDialog(null, "Ha ganado el " + c1);
            p1++;
            Reset();
            labelg1.setText("Ganadas: "+p1);
            turn=2;
            CambiarTurno();
            CPU();
        }
        else if (Bot1.getText()=="O" && Bot2.getText()=="O" && Bot3.getText()=="O")
        {
            JOptionPane.showMessageDialog(null, "Ha ganado " + c2);
            p2++;
            Reset();
            labelg2.setText("Ganadas: "+p2);
            turn=1;
            CambiarTurno();
        }
    }
    
    public void AnalisisEmpate()
    {
        if (bt1.getText()!="" && bt2.getText()!="" && bt3.getText()!="" && bt4.getText()!="" &&
            bt5.getText()!="" && bt6.getText()!="" && bt7.getText()!="" && bt8.getText()!="" &&
            bt9.getText()!="")
        {
            JOptionPane.showMessageDialog(null, "Ha sido un empate");
            Reset();
        }
    }
    
    public void DeterminarGanador()
    {
        Ganar(bt1,bt2,bt3);
        Ganar(bt4,bt5,bt6);
        Ganar(bt7,bt8,bt9);
        Ganar(bt1,bt4,bt7);
        Ganar(bt2,bt5,bt8);
        Ganar(bt3,bt6,bt9);
        Ganar(bt1,bt5,bt9);
        Ganar(bt3,bt5,bt7);
        AnalisisEmpate();
    }
    
    public void Maquina(JButton B1, JButton B2, JButton B3)
    {

        if(B1.getText()=="" && B2.getText()=="X" && B3.getText()=="X")
        {
            B1.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if(B1.getText()=="X" && B2.getText()=="" && B3.getText()=="X")
        {
            B2.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if(B1.getText()=="X" && B2.getText()=="X" && B3.getText()=="")
        {
            B3.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if(B1.getText()=="O" && B2.getText()=="O" && B3.getText()=="")
        {
            B3.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if(B1.getText()=="O" && B2.getText()=="" && B3.getText()=="O")
        {
            B2.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if(B1.getText()=="" && B2.getText()=="O" && B3.getText()=="O")
        {
            B1.setText("O");
            turn=1;
            CambiarTurno();
        }
        else if (bt1.getText()!="" && bt2.getText()!="" && bt3.getText()!="" && bt4.getText()!="" &&
                bt5.getText()!="" && bt6.getText()!="" && bt7.getText()!="" && bt8.getText()!="" &&
                bt9.getText()!="")
        {
            JOptionPane.showMessageDialog(null, "Ha sido un empate");
            Reset();
        }
        
    }

    public void CPU()
    {
        if(jugadores==1)
        {
            if(turn==2)
            {
                Maquina(bt1,bt2,bt3);
            }
            if(turn==2)
            {
                Maquina(bt4,bt5,bt6);
            }
            if(turn==2)
            {
                Maquina(bt7,bt8,bt9);
            }
            if(turn==2)
            {
                Maquina(bt1,bt4,bt7);
            }
            if(turn==2)
            {
                Maquina(bt2,bt5,bt8);
            }
            if(turn==2)
            {
                Maquina(bt3,bt6,bt9);
            }
            if(turn==2)
            {
                Maquina(bt1,bt5,bt9);
            }
            if(turn==2)
            {
                Maquina(bt3,bt5,bt7);
            }
            if(turn==2)
            {
                Random seleccion = new Random();
                int aux;
                boolean auxb=true;

                do
                {
                    aux=seleccion.nextInt(9);

                    if(List[aux].getText()=="")
                    {
                        List[aux].setText("O");
                        auxb=false;
                    }
                }
                while(auxb);
                turn=1;
                CambiarTurno();
            }
            
        }
    }
    
    public void Jugador1(JButton boton)
    {
        if (boton.getText()=="")
        {
            boton.setText("X");
            turn=2;
            CambiarTurno();
        }
        DeterminarGanador();
        CPU();
        DeterminarGanador();
    }
    
    public void Jugadores2(JButton boton)
    {
        if (boton.getText()=="")
        {
            if(turn==1)
            {
                boton.setText("X");
                turn=2;
                CambiarTurno();
            }
            else if(turn==2)
            {
                boton.setText("O");
                turn=1;
                CambiarTurno();
            }
        }
        DeterminarGanador();
    }
    
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gruporb = new javax.swing.ButtonGroup();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        labelj1 = new javax.swing.JLabel();
        labelg1 = new javax.swing.JLabel();
        labelg2 = new javax.swing.JLabel();
        labelj2 = new javax.swing.JLabel();
        Turno = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Juego = new javax.swing.JMenu();
        Reiniciar = new javax.swing.JMenuItem();
        ReiniciarPuntaje = new javax.swing.JMenuItem();
        Cerrar = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        Instrucciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });

        bt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt9ActionPerformed(evt);
            }
        });

        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        labelj1.setText("Jugador 1");

        labelg1.setText("Ganadas:");

        labelg2.setText("Ganadas:");

        labelj2.setText("Jugador 2");

        Turno.setText("Turno:");

        Gruporb.add(rb1);
        rb1.setText("Jugador VS CPU");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        Gruporb.add(rb2);
        rb2.setText("Jugador VS Jugador");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        Juego.setText("Juego");

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });
        Juego.add(Reiniciar);

        ReiniciarPuntaje.setText("Reiniciar Puntaje");
        ReiniciarPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarPuntajeActionPerformed(evt);
            }
        });
        Juego.add(ReiniciarPuntaje);

        Cerrar.setText("Cerrar");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        Juego.add(Cerrar);

        jMenuBar1.add(Juego);

        Ayuda.setText("Ayuda");

        Instrucciones.setText("Cómo jugar");
        Instrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstruccionesActionPerformed(evt);
            }
        });
        Ayuda.add(Instrucciones);

        jMenuBar1.add(Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rb1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelj1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 3, Short.MAX_VALUE)))
                                .addGap(80, 80, 80))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelj2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rb2)
                                    .addComponent(labelg2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Turno, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelj1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelg1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelj2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelg2)
                        .addGap(52, 52, 52))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt2);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt2);
        }
    }//GEN-LAST:event_bt2ActionPerformed

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt3ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt3);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt3);
        }
    }//GEN-LAST:event_bt3ActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt1);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt1);
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt5ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt5);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt5);
        }
    }//GEN-LAST:event_bt5ActionPerformed

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt6ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt6);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt6);
        }
    }//GEN-LAST:event_bt6ActionPerformed

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt4ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt4);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt4);
        }
    }//GEN-LAST:event_bt4ActionPerformed

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt8ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt8);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt8);
        }
    }//GEN-LAST:event_bt8ActionPerformed

    private void bt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt9ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt9);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt9);
        }
    }//GEN-LAST:event_bt9ActionPerformed

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt7ActionPerformed

        if(jugadores==1)
        {
            Jugador1(bt7);
        }
        else if(jugadores==2)
        {
            Jugadores2(bt7);
        }
    }//GEN-LAST:event_bt7ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        jugadores=1;
        p1=0;
        p2=0;
        Reset();
        turn=1;
        CambiarTurno();
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        jugadores=2;
        p1=0;
        p2=0;
        Reset();
        turn=1;
        CambiarTurno();
    }//GEN-LAST:event_rb2ActionPerformed

    private void ReiniciarPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarPuntajeActionPerformed
        p1=0;
        p2=0;
        CambiarTurno();
    }//GEN-LAST:event_ReiniciarPuntajeActionPerformed

    private void InstruccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstruccionesActionPerformed
        String mensaje = "CÓMO JUGAR\n" +
        "\n" +
        "El objetivo del juego es conectar 3 símbolos seguidos, según el símbolo que te \n" +
        "corresponda (una X o una O). El primero en lograr conectar 3 símbolos gana la partida.\n" +
        "Si los espacios disponibles se acaban y ninguno logra conectar los 3 símbolos, es un\n" +
        "empate.\n" +
        "\n" +
        "-----------------------------------------------------------------------------------------------------------------\n" +
        "\n" +
        "MODOS DE JUEGO\n" +
        "\n" +
        "- Jugador VS CPU\n" +
        "\n" +
        "- Jugador VS Jugador";
        
        JOptionPane.showMessageDialog(null,mensaje);
    }//GEN-LAST:event_InstruccionesActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        Reset();
        turn=1;
        CambiarTurno();
    }//GEN-LAST:event_ReiniciarActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenuItem Cerrar;
    private javax.swing.ButtonGroup Gruporb;
    private javax.swing.JMenuItem Instrucciones;
    private javax.swing.JMenu Juego;
    private javax.swing.JMenuItem Reiniciar;
    private javax.swing.JMenuItem ReiniciarPuntaje;
    private javax.swing.JLabel Turno;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelg1;
    private javax.swing.JLabel labelg2;
    private javax.swing.JLabel labelj1;
    private javax.swing.JLabel labelj2;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    // End of variables declaration//GEN-END:variables
}
