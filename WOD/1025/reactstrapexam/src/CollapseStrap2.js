import { useState } from 'react';
import { Collapse, Button, Card, CardBody} from 'reactstrap';

function CollapseStrap2() {

    const [open, setOpen] = useState(false);
    const [status, setStatus] = useState("Closed");
    const [idx, setIdx] = useState(0);
    const contents = [
        "럼피스킨병은 소에게만 감염되는 전염병으로 증상으로는 고열과 단단한 혹 같은 피부 결절이 특징이다.",
        "\"청년이 노동시장에 원활히 진입·재진입할 수 있도록 기간제·파견 규제 완화, 유연근무제 확대 등을 적극 추진해 다양한 생산방식을 보장하는 방향으로 노동 시장 유연성을 높여나가야 한다\"며 \"근로자가 수행하는 직무의 가치와 성과에 따른 임금체계 구축을 지원함으로써 청년들의 노동시장 진입장벽을 낮출 필요가 있다\""
    ]

    const entering = () => {
        setStatus("Opening");
        if(idx==contents.length-1) setIdx(0);
        else setIdx(idx+1);
    }

    const entered = () => {
        setStatus("Opened");
    }

    const exiting = () => {
        setStatus("Closing");
    }

    const exited = () => {
        setStatus("Closed");
    }
    return (
        <>
            <div>
                <Button onClick={()=>setOpen(!open)} style={{marginBottom:"10px"}}>Toggle</Button>
                <h5>Current state : {status}</h5>
                <Collapse isOpen={open}
                    onEntering={entering}
                    onEntered={entered}
                    onExiting={exiting}
                    onExited={exited}
                >
                    

                    <Card>
                        <CardBody>
                            {contents[idx]}
                        </CardBody>
                    </Card>

                </Collapse>
            </div>
        </>
    )
}

export default CollapseStrap2;