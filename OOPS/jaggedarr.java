class jaggedarr{
    public static void main(String[]args){
        int[][] student=new int[3][];
        student[0]=new int[1];
        student[1]=new int[2];
        student[2]=new int[3];
        for(int i=0;i<student.length;i++){
            for(int j=0;j<student[i].length;j++){
                student[i][j]=(i+10)*(j+2);   
        }
    }
    for(int i=0;i<student.length;i++){
        System.out.print("Student "+(i+1)+": ");
        for(int j=0;j<student[i].length;j++)
        {
            System.out.print(student[i][j]+" ");
        }
        System.out.println();
    }
}
}