package br.unicap.nomedisciplina.atividade00.TestObjective;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.unicap.nomedisciplina.atividade00.match.*;
import br.unicap.nomedisciplina.atividade00.calculations.*;
import br.unicap.nomedisciplina.atividade00.match.Objective.*;

import java.util.LinkedList;

public class TestEliminateTarget {
    private LinkedList<Player> playes;
    private Player player;
    private Objective objective;
    private MatchCreation creation;
    private StartingAttributes attributes;
    private ObjetiveValidation actualValidation;


    @BeforeEach
    public void setUp() {
        this.creation = new MatchCreation();
        this.attributes = new StartingAttributes();
        this.actualValidation = new ObjetiveValidation();
        this.playes = new LinkedList<>();
        creation.creationPlayer(this.playes);
        this.objective = new ObjectiveEliminateTarget(0, this.attributes.getColor()[1], this.attributes.getDescription()[0], this.playes.getFirst().getId());
        creation.creationObjectiveTargetInMatch(this.playes, (ObjectiveEliminateTarget) this.objective);
        this.playes.getFirst().setObjPlayer(this.objective);
        this.player = this.playes.getFirst();
        this.attributes.setEarlyArmys(this.player.getTotalArmys());
    }

    @Test
    public void testActualPlayerhasObjectiveEliminateTarget() {
        boolean actual = actualValidation.validationSameObjective(this.player, this.objective);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerhasNotObjectiveEliminateTarget() {
        Objective newObjective = new ObjectiveConquestTerritorySpecific(6, this.attributes.getDescription()[1], this.player.getId());
        this.player.setObjPlayer(newObjective);
        boolean actual = actualValidation.validationSameObjective(this.player, this.objective);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerisNotTheSameTarget() {
        boolean actual = actualValidation.validationSameTarget(this.player, (ObjectiveEliminateTarget) this.objective);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerisTheSameTarget() {
        ObjectiveEliminateTarget newObjective = new ObjectiveEliminateTarget(0, this.attributes.getColor()[0], this.attributes.getDescription()[0], this.player.getId());
        this.player.setObjPlayer(newObjective);
        boolean actual = actualValidation.validationSameTarget(this.player, newObjective);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualTargetisInTheMatch() {
        boolean actual = actualValidation.validationTargetInMatch(this.playes, this.objective);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualTargetisNotInTheMatch() {
        ObjectiveEliminateTarget newObjective = new ObjectiveEliminateTarget(0, "Purple", this.attributes.getDescription()[0], this.player.getId());
        creation.creationObjectiveTargetInMatch(this.playes, newObjective);
        boolean actual = actualValidation.validationTargetInMatch(this.playes, newObjective);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualPlayerEliminatedTarget() {
        this.creation.afterSuccessfulConfrontation(this.playes, (ObjectiveEliminateTarget) this.objective, this.player.getId(), this.attributes.getEarlyArmys());
        this.player = this.playes.getFirst();
        boolean actual =  actualValidation.validationEliminatedTarget(this.playes, (ObjectiveEliminateTarget) this.objective, this.player);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testOtherPlayerEliminatedTarget() {
        this.creation.afterSuccessfulConfrontation(this.playes, (ObjectiveEliminateTarget) this.objective, 2, this.attributes.getEarlyArmys());
        this.player = this.playes.getFirst();
        boolean actual =  actualValidation.validationEliminatedTarget(this.playes, (ObjectiveEliminateTarget) this.objective, this.player);
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testActualTargetisYetInMatch() {
        this.creation.afterSuccessfulConfrontation(this.playes, (ObjectiveEliminateTarget) this.objective, 2, this.attributes.getEarlyArmys() - 1);
        this.player = this.playes.getFirst();
        boolean actual =  actualValidation.validationEliminatedTarget(this.playes, (ObjectiveEliminateTarget) this.objective, this.player);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }
}