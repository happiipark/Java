import { Button } from 'reactstrap';
import Swal from 'sweetalert2';


function Sweetalert2Basic(){

    const confirm =() => {
        Swal.fire("삭제했습니다.").then(result=>{
            console.log(result.value);
        })
    }

    return(
        <div>
            <Button onClick={confirm}>삭제</Button>
        </div>
    )
}

export default Sweetalert2Basic;