
Ref reverse(Ref input){
    Q left=left(input);
    Q right=right(input);
    Q deteck=right((Ref)right);
    if (isNil(right)==1){
        return left;
    }
    return reverse((Ref)right). (left.nil);
}

int isSorted (Ref input){
    int result=0;
    if (isNil(input)==1){
        return 0;
    }
    Q left=left(input);
    Q right=right(input);
    if (isAtom(right)==1){
        return isSorted(right)+1;
    }
    result=  isSorted(right)-isSorted(left);
  
}