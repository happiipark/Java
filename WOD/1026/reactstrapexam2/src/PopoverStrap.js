import { useEffect, useState } from 'react';
import { Button, Popover, PopoverHeader, PopoverBody, Progress} from 'reactstrap';


function PopoverStrap(){

    const [open, setOpen] = useState(false);
    const [value, setValue] = useState(0);
    useEffect(()=> {
        setInterval(()=>{
            if(value<100)
            setValue(value+1);
        },1000)
    },[value])


    return(
        <div style={{width:"800px"}}>
            <Button onClick={()=>setOpen(!open)} id="Popover1">양자전략위원회</Button>
            <Popover placement="bottom" isOpen={open} target="Popover1" toggle={()=>setOpen(!open)}>
                <PopoverHeader>정부 양자기술 컨트롤타워</PopoverHeader>                
                <PopoverBody>
                    국무총리를 위원장으로 하는 범부처 양자 기술 컨트롤타워로, 기존 양자기술특별위원회를 확대개편한 '양자'
                </PopoverBody>
            </Popover>
            <br/><br/>
            <Progress value={value}/>
        </div>
    )
}

export default PopoverStrap;