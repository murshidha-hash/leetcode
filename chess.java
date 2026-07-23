class chess {
    public boolean squareIsWhite(String coordinates) {
        char col = coordinates.charAt(0);
        char row = coordinates.charAt(1);
        int colnum=col-'a'+1;
        int rownum=row-'0';
        return(colnum+rownum)%2!=0;
    }
}