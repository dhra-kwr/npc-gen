package npcgenerator;

import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class NPCgenerator extends JFrame {
    
    private JPanel mainPanel, genderPanel, racePanel, npcPanel, npcLabelPanel, 
            npcTextFieldPanel;
    private JRadioButton male, female, na, human, cambion, changeling, clockwork, 
            dwarf, elf, faun, goblin, hobgoblin, jotun, orc, pixie, revenant, 
            salamander;
    private ButtonGroup genderGroup, raceGroup;
    private Border kehys;
    private TitledBorder genderBorder, raceBorder, npcBorder;
    private JLabel nameLabel, genderLabel, raceLabel, traitLabel, physicalLabel,
            personalityLabel, motivationLabel;
    private JTextField physicalTrait, personalityTrait, motivation;
    private JButton createNPC;
    
    public NPCgenerator() {
        setTitle("NPCs, bit*es!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(350, 600);
        mainPanel = new JPanel();
        genderPanel = new JPanel();
        racePanel = new JPanel(new GridLayout(0,3));
        npcPanel = new JPanel();
        npcLabelPanel = new JPanel(new GridLayout(0,1));
        npcTextFieldPanel = new JPanel(new GridLayout(0,1));
        
        //gender buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        na = new JRadioButton("N/A");
        
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(na);

        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(na);
        kehys = BorderFactory.createEtchedBorder();
        genderBorder = BorderFactory.createTitledBorder(kehys, "Gender");
        genderPanel.setBorder(genderBorder);
        
        //race buttons
        human = new JRadioButton("Human");
        cambion = new JRadioButton("Cambion");
        changeling = new JRadioButton("Changeling");
        clockwork = new JRadioButton("Clockwork");
        dwarf = new JRadioButton("Dwarf");
        faun = new JRadioButton("Faun");
        elf = new JRadioButton("Elf");
        goblin = new JRadioButton("Goblin");
        hobgoblin = new JRadioButton("Hobgoblin");
        jotun = new JRadioButton("Jotun");
        orc = new JRadioButton("Orc");
        pixie = new JRadioButton("Pixie");
        revenant = new JRadioButton("Revenant");
        salamander = new JRadioButton("Salamander");
        
        raceGroup = new ButtonGroup();
        raceGroup.add(human);
        raceGroup.add(cambion);
        raceGroup.add(changeling);
        raceGroup.add(clockwork);
        raceGroup.add(dwarf);
        raceGroup.add(elf);
        raceGroup.add(faun);
        raceGroup.add(goblin);
        raceGroup.add(hobgoblin);
        raceGroup.add(jotun);
        raceGroup.add(orc);
        raceGroup.add(pixie);
        raceGroup.add(revenant);
        raceGroup.add(salamander);
        
        racePanel.add(human);
        racePanel.add(cambion);
        racePanel.add(changeling);
        racePanel.add(clockwork);
        racePanel.add(dwarf);
        racePanel.add(elf);
        racePanel.add(faun);
        racePanel.add(goblin);
        racePanel.add(hobgoblin);
        racePanel.add(jotun);
        racePanel.add(orc);
        racePanel.add(pixie);
        racePanel.add(revenant);
        racePanel.add(salamander);
        raceBorder = BorderFactory.createTitledBorder(kehys, "Race");
        racePanel.setBorder(raceBorder);
        
        //npc random name & trait generator panel (+ show gender and race)
        createNPC = new JButton("Create");
        nameLabel = new JLabel("Name: ");
        genderLabel = new JLabel("Gender: ");
        raceLabel = new JLabel ("Race: ");
        physicalLabel = new JLabel("Physical trait:");
        personalityLabel = new JLabel("Personality trait:");
        motivationLabel = new JLabel("Motivation:");
        
        physicalTrait = new JTextField(25);
        personalityTrait = new JTextField(25);
        motivation = new JTextField(25);
        
        npcTextFieldPanel.add(createNPC);
        npcTextFieldPanel.add(nameLabel);
        npcTextFieldPanel.add(genderLabel);
        npcTextFieldPanel.add(raceLabel);
        npcTextFieldPanel.add(physicalLabel);
        npcTextFieldPanel.add(physicalTrait);
        npcTextFieldPanel.add(personalityLabel);
        npcTextFieldPanel.add(personalityTrait);
        npcTextFieldPanel.add(motivationLabel);
        npcTextFieldPanel.add(motivation);
        npcPanel.add(npcTextFieldPanel);
        
        npcBorder = BorderFactory.createTitledBorder(kehys, "Create your NPC!");
        npcPanel.setBorder(npcBorder);
        
        mainPanel.add(genderPanel);
        mainPanel.add(racePanel);
        mainPanel.add(npcPanel);
        
        setContentPane(mainPanel);
        //pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new NPCgenerator();
        
    }
    
}