namespace java com.lwl

include "ShitPO.thrift"

service JazzClient{

    bool exists(1:string path)

    string shit(1:bool success)

    ShitPO.ShitPO getShit(1:i32 id, 2:ShitPO.ShitPO shitPO)
}