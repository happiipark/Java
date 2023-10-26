import { Tooltip } from "reactstrap";
import { useState } from 'react';

function TooltipsStrap(){

    const [open, setOpen] = useState(false);

    return(
        <div style={{width:"800px"}}>
            <p>Somewhere in here is a <span style={{textDecoration:"underline", color:"blue"}} id="tooltip">tooltip</span></p>
            <Tooltip placement="right" isOpen={open} target="tooltip" toggle={()=>setOpen(!open)}>Hello Tooltip!</Tooltip>
        </div>
    )
}

export default TooltipsStrap;