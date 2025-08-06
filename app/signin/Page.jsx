import AuthForm from "@/components/AuthForm";
import { loginUser } from "@/utils/api";

export default function SigninPage() {
  return <AuthForm type="signin" onSubmit={loginUser} />;
}
