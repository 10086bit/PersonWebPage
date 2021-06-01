package com.zqt.domain.user;

public class Page {
    private  int start;
    private  int total;
    private  int count;

    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }
    public boolean isHasPre(){
        if(getStart()==0){
            return false;
        }
        return true;
    }
    public boolean isHasNext(){
        if(getStart()==getLast()){
            return false;
        }
        else{
            return true;
        }
    }
    public int getLast(){
        int last;
        if (count>total){
            last=total;
        }else {
            if(0==total%count){
                last=total-count;
            }else {
                last=total-total%count;
            }

        }
        return last;
    }

   public int getTotalPage(){
        int totalPage;
        if (0==total%count){
            totalPage=total/count;
        }else {
            totalPage=total/count+1;
        }
        if (totalPage==0){
            totalPage=1;
        }
        return totalPage;

   }
}
