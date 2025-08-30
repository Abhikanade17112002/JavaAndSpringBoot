

public class Question{
    
    public Question(int questionId, String question, String[] options, String answere) {
        this.questionId = questionId;
        this.question = question;
        this.options = options;
        this.answere = answere;
    }

    private int questionId ;
    private String question ;
    private String [] options ;
    private String answere ;
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String[] getOptions() {
        return options;
    }
    public void setOptions(String[] options) {
        this.options = options;
    }
    public String getAnswere() {
        return answere;
    }
    public void setAnswere(String answere) {
        this.answere = answere;
    }
    
    
}