"use client"
import React, { useEffect, useState } from "react"
import Link from "next/link"
import axios from "axios"
import { useRouter } from 'next/navigation'
import { Button } from "@/components/ui/button"
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"

export const description =
  "A login form with email and password. There's an option to login with Google and a link to sign up if you don't have an account."

export default function LoginForm() {
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [error, setError] = useState("")
  const router = useRouter()


  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault(); // 기본 폼 제출 동작 방지

    try {
      const response = await axios.post(`${process.env.NEXT_PUBLIC_API_URL}/api/user/login`, {
        username,
        password,
      });

      console.log("로그인 성공:", response.data);

      router.push('/');
      
      
      // 성공 시 추가적인 작업 (예: 리다이렉트, 토큰 저장 등)을 수행
    } catch (error) {
      // 오류 처리
      if (axios.isAxiosError(error) && error.response) {
        // 서버에서 반환한 에러 메시지
        setError(error.response.data || "로그인 실패");
      } else {
        // 네트워크 오류 등
        setError("로그인 실패: 네트워크 오류");
      }
    }
  }

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
    <Card className="mx-auto max-w-sm">
      <CardHeader>
        <CardTitle className="text-2xl">Login</CardTitle>
        <CardDescription>
          Enter your username below to login to your account
        </CardDescription>
      </CardHeader>
      <CardContent>
        {error && <p className="text-red-500">{error}</p>} {/* 에러 메시지 표시 */}
        <form onSubmit={handleSubmit} className="grid gap-4">
          <div className="grid gap-2">
            <Label htmlFor="username">Username</Label>
            <Input
              id="username"
              type="text"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div className="grid gap-2">
            <div className="flex items-center">
              <Label htmlFor="password">Password</Label>
              <Link href="#" className="ml-auto inline-block text-sm underline">
                Forgot your password?
              </Link>
            </div>
            <Input
              id="password"
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <Button type="submit" className="w-full">
            Login
          </Button>
        </form>
        <div className="mt-4 text-center text-sm">
          Don&apos;t have an account?{" "}
          <Link href="#" className="underline">
            Sign up
          </Link>
        </div>
      </CardContent>
    </Card>
    </main>
    
  )
}
