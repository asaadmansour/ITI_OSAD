class Test {
    String word;
    Test(String word) {
        this.word = word;
    }
    public boolean containsNumber(String word) {
            char[] wordChar = word.toCharArray();
        for(int i=0;i<wordChar.length;i++) {
            if(!Character.isLetter(wordChar[i])) {
                return false;
            } 
        }
        return true;
    }

}