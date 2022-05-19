mutable Q main (int arg){
    if (arg==1){
        Ref a=1.2.3.4.5.6.7.8.9.10.11.12.13.14.15.16.17.18;
       return a;
    }
    if (arg==2){
        Ref a=1.2;
        mutable Ref b1=a.(a.a);
        mutable Ref b2=a.(a.b1);
        mutable Ref b3=a.(a.b2);
        setRight((Ref)right(b1),b3);
        b1=nil;
        b2=nil;
        b3=nil;
        Ref c=1.2.3.4.5.6.7.8.9.10.11.12.13.14.15;
       return c;
    }
    if (arg==3){
       Ref a=1.(2.3.4.5.6.7.8.9.10.11.12.13.14.15.16);
       free(a);
       Ref c=1.2.3;
       return a;
    }
    if (arg==4){
       Ref a=var();
       Ref b=var();
       return a;
    }
    return 0;
}

Ref var(){
    Ref a=1.(2.3.4.5.6.7.8.9.10.11.12.13.14);
    free(a);
    Ref c=1.2;
    return c;
}