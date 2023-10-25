import { useState } from 'react';
import { Button, Fade } from 'reactstrap';

function FadeStrap() {

    const [fadeIn, setFadeIn] = useState(true);
    const fadeStyle = {width:"200px", margin:"2px auto", border:"solid gray 1px", padding:"5px"};
    return (
        <>
            <Button color="success" onClick={()=> setFadeIn(!fadeIn)} >Fade In/Out</Button>
            <Fade in={fadeIn} tag="p" style={fadeStyle}>
            럼피스킨병은 소에게만 감염되는 전염병으로 증상으로는 고열과 단단한 혹 같은 피부 결절이 특징이다.
            </Fade>
            <p>다음 글입니다.....</p>
        </>
    )
}

export default FadeStrap;