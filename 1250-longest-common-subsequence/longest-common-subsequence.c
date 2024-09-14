int longestCommonSubsequence(char* char1, char* char2) {
    int r=strlen(char1);
    int c=strlen(char2);
    int a[r+1][c+1];
    for(int i=0;i<r+1;i++){
        for(int j=0;j<c+1;j++){
            a[i][j]=0;
        }
    }
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            if(char1[i-1]==char2[j-1]){
                a[i][j]=a[i-1][j-1]+1;
            }
            else{
                a[i][j]=(a[i-1][j]>a[i][j-1])?a[i-1][j]:a[i][j-1];
            }
        }
    }
    return a[r][c];
}