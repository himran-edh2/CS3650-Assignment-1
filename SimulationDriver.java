public class SimulationDriver {
    public static void main (String[] args) {
        iVoteSimulation simulation1 = new iVoteSimulation();
        simulation1.setNumberOfParticipants();
        simulation1.getNumberOfParticipants(); 
        simulation1.setTypeOfQuestion();
        simulation1.setID();
        simulation1.getChoices();
        simulation1.results();
    }
}
