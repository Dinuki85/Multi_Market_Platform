import AuthForm from "@/components/AuthForm";
import { registerUser } from "@/utils/api";

export default function SignupPage() {
  return <AuthForm type="signup" onSubmit={registerUser} />;
}