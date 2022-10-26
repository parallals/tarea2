package tarea2;

abstract class Moneda{
    abstract public int getValor();
    public String getSerie(){
        return toString();
    }
    public Moneda(){
    }
}

class Moneda1000 extends Moneda{
    public Moneda1000(){
    }
    @Override
    public int getValor(){
        return 1000;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
    }
    @Override
    public int getValor(){
        return 500;
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
    }
    @Override
    public int getValor(){
        return 100;
    }
}